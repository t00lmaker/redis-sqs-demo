package xyz.equalsp.redissqsdemo

interface MovieService {

    @Throws(Exception::class)
    fun getMovie(id: String): Movie

    fun getAllMovies(): List<Movie>

    @Throws(Exception::class)
    fun updateMovie(id: String, movieDto: MovieController.MovieDto): Movie

    fun updateMovie(movie: Movie): Movie

    fun createMovie(movieDto: MovieController.MovieDto) : Movie

    @Throws(Exception::class)
    fun deleteMovie(id: String)
}