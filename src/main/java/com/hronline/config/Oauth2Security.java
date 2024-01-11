package com.hronline.config;

import com.hronline.obj.AuthzRequest;
import org.keycloak.AuthorizationContext;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Component("oauth2Security")
public class Oauth2Security  {

    public boolean hasResourcePermission(HttpServletRequest httpServletRequest, String resourceName, String scope) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            return false;
        }
        KeycloakSecurityContext keycloakSecurityContext = (KeycloakSecurityContext) httpServletRequest.getAttribute(KeycloakSecurityContext.class.getName());
        AuthorizationContext authzContext = keycloakSecurityContext.getAuthorizationContext();
        return authzContext.hasPermission(resourceName, scope);
    }

    public boolean hasResourcePermission(HttpServletRequest httpServletRequest, String resourceName, String... scopes) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            return false;
        }
        KeycloakSecurityContext keycloakSecurityContext = (KeycloakSecurityContext) httpServletRequest.getAttribute(KeycloakSecurityContext.class.getName());
        AuthorizationContext authzContext = keycloakSecurityContext.getAuthorizationContext();
        return Arrays.stream(scopes).allMatch(item -> authzContext.hasPermission(resourceName, item));
    }

    public boolean hasMultipleResourcePermission(HttpServletRequest httpServletRequest, List<AuthzRequest> authzRequestList) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            return false;
        }
        KeycloakSecurityContext keycloakSecurityContext = (KeycloakSecurityContext) httpServletRequest.getAttribute(KeycloakSecurityContext.class.getName());
        AuthorizationContext authzContext = keycloakSecurityContext.getAuthorizationContext();
        boolean hasPerm = true;
        for (int i = 0; i < authzRequestList.size() && hasPerm; i++) {
            AuthzRequest request = authzRequestList.get(i);
            hasPerm = request.getScopes().parallelStream().allMatch(item -> authzContext.hasPermission(request.getResourceName(), item));
        }
        return hasPerm;
    }

    public boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            return false;
        }
        return authentication.isAuthenticated();
    }

    public boolean isAnonymous() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication instanceof AnonymousAuthenticationToken;
    }

    public String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            return null;
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        KeycloakPrincipal principal = (KeycloakPrincipal)auth.getPrincipal();
        return principal.getKeycloakSecurityContext().getToken().getPreferredUsername();
    }
}
