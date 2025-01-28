/*
 * SPDX-FileCopyrightText: 2025 Swiss Confederation
 *
 * SPDX-License-Identifier: MIT
 */

package ch.admin.bit.eid.datastore.vc.service;

import ch.admin.bit.eid.datastore.vc.model.entity.VcEntity;
import ch.admin.bit.eid.datastore.vc.repository.VcEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@AllArgsConstructor
public class VcEntityService {

    private final VcEntityRepository vcEntityRepository;

    public List<String> getTrustStatementsForDid(String did, Boolean filterActive) {
        if (Boolean.TRUE.equals(filterActive)) {
            Long now = Instant.now().toEpochMilli() / 1000;
            return this.vcEntityRepository.findBySubjectDidAndTimeLimits(did, now, now)
                    .stream()
                    .map(VcEntity::getRawVc)
                    .toList();
        } else {
            return this.vcEntityRepository.findBySubjectDid(did).stream().map(VcEntity::getRawVc).toList();
        }
    }
}
