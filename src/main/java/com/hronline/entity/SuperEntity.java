package com.hronline.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.search.engine.backend.types.Searchable;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.bridge.builtin.impl.DefaultLocalDateTimeBridge;
import org.hibernate.search.mapper.pojo.bridge.mapping.annotation.ValueBridgeRef;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.validator.cfg.defs.ISBNDef;
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
    protected String createdBy;

    @Column(name = "create_date")
    @GenericField(sortable = Sortable.YES)
    protected LocalDateTime createdDate;

    @Column(name = "modify_by", length = 100)
    protected String modifyBy;

    @Column(name = "modify_date")
    @GenericField(sortable = Sortable.YES)
    protected LocalDateTime modifyDate;

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
