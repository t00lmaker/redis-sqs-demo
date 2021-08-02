package xyz.equalsp.redissqsdemo

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed
import java.time.LocalDate

@RedisHash("Actors")
data class Actor(
    var id: String? = null,
    @Indexed val firstName: String,
    val lastName: String,
    val birthDate: LocalDate
) {
}