package xyz.equalsp.redissqsdemo

interface ActorService {

    @Throws(Exception::class)
    fun getActor(id: String): Actor

    fun getAllActors(): List<Actor>

    @Throws(Exception::class)
    fun updateActor(id: String, actorDto: ActorController.ActorDto): Actor

    fun createActor(actorDto: ActorController.ActorDto): Actor

    @Throws(Exception::class)
    fun deleteActor(id: String)

    @Throws(Exception::class, Exception::class)
    fun addActorToMovie(actorId: String, movieId: String): Movie
}