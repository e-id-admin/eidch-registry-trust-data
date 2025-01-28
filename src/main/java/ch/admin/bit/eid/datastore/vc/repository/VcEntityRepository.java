/*
 * SPDX-FileCopyrightText: 2025 Swiss Confederation
 *
 * SPDX-License-Identifier: MIT
 */

package ch.admin.bit.eid.datastore.vc.repository;

import ch.admin.bit.eid.datastore.vc.model.entity.VcEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VcEntityRepository extends JpaRepository<VcEntity, Long> {
    @Query(
            value = """
                    SELECT * FROM vc_entity WHERE (vc_payload->>'sub') = :did
                    """,
            nativeQuery = true
    )
    List<VcEntity> findBySubjectDid(@Param("did") String did);

    @Query(
            value = """
                    SELECT * FROM vc_entity WHERE (vc_payload->>'sub') = :did AND
                                                (vc_payload->>'exp')::bigint >= :min_exp AND
                                                (vc_payload->>'nbf')::bigint <= :max_nbf
                    """,
            nativeQuery = true
    )
    List<VcEntity> findBySubjectDidAndTimeLimits(
            @Param("did") String did,
            @Param("min_exp") Long min_exp,
            @Param("max_nbf") Long max_nbf
    );
}
