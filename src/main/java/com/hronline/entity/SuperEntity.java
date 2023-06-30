package com.hronline.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.keycloak.KeycloakPrincipal;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@ToString
public class SuperEntity {

    @Column(name = "create_by", length = 100)
    private String createdBy;

    @Column(name = "create_date")
    private LocalDateTime createdDate;

    @Column(name = "modify_by", length = 100)
    private String modifyBy;

    @Column(name = "modify_date")
    private LocalDateTime modifyDate;

    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            KeycloakPrincipal principal = (KeycloakPrincipal) authentication.getPrincipal();
            if (principal != null)
                this.createdBy = principal.getKeycloakSecurityContext().getToken().getPreferredUsername();
        }
    }

    @PreUpdate
    protected void onUpdate() {
        this.modifyDate = LocalDateTime.now();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            KeycloakPrincipal principal = (KeycloakPrincipal) authentication.getPrincipal();
            if (principal != null)
                this.modifyBy = principal.getKeycloakSecurityContext().getToken().getPreferredUsername();
        }
    }
}
