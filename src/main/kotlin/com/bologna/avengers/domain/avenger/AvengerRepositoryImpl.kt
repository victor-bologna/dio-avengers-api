package com.bologna.avengers.domain.avenger

import com.bologna.avengers.resource.avenger.AvengerEntity
import com.bologna.avengers.resource.avenger.AvengerEntityRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class AvengerRepositoryImpl(
    private val avengerEntityRepository: AvengerEntityRepository
): AvengerRepository {
    override fun getAvenger(id: Long): Avenger? {
        return avengerEntityRepository.findByIdOrNull(id)?.toAvenger()
    }

    override fun getAvengers(): List<Avenger> {
        return avengerEntityRepository.findAll().toList().map { it.toAvenger() }
    }

    override fun create(avenger: Avenger): Avenger {
        return avengerEntityRepository.save(AvengerEntity.from(avenger)).toAvenger()
    }

    override fun delete(id: Long) {
        avengerEntityRepository.deleteById(id)
    }

    override fun update(avenger: Avenger): Avenger {
        return avengerEntityRepository.save(AvengerEntity.from(avenger)).toAvenger()
    }
}