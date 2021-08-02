package xyz.equalsp.redissqsdemo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DefaultActorService : ActorService{

    @Autowired
    lateinit var actorRepository: ActorRepository
    @Autowired
    lateinit var movieService: MovieService

    override fun getActor(id: String) = actorRepository.findById(id).orElseThrow {
        Exception("Unable to find movie for $id id")
    }

    override fun getAllActors(): List<Actor> = actorRepository.findAll().toList()

    override fun updateActor(id: String, actorDto: ActorController.ActorDto): Actor {
        val actor = getActor(id).copy(id, actorDto.firstName, actorDto.lastName, actorDto.birthDate)
        actor.id = id
        return actorRepository.save(actor)
    }

    override fun createActor(actorDto: ActorController.ActorDto): Actor {
        return actorRepository.save(Actor(actorDto.id, actorDto.firstName, actorDto.lastName, actorDto.birthDate))
    }

    override fun deleteActor(id: String) = actorRepository.deleteById(id)

    override fun addActorToMovie(actorId: String, movieId: String): Movie {
        val movie: Movie = movieService.getMovie(movieId)
        val actor: Actor = getActor(actorId)
        (movie.actors as ArrayList).add(actor)
        return movieService.updateMovie(movie)
    }
}