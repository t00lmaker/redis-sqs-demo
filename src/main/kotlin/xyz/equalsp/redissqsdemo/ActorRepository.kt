package xyz.equalsp.redissqsdemo

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ActorRepository : CrudRepository<Actor, String>