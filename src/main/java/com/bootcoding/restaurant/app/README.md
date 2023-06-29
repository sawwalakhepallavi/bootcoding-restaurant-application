## API Contracts
### 1.Get Longest Duration Movies
- Method: GET
- Endpoint: `/api/v1/movies/longest-duration-movies`
- Request Parameters:`limit` (optional, default: 10): Specifies the maximum number of movies to retrieve.
`sortType` (optional, default: "DESC"): Specifies the sorting order of movies based on duration ("ASC" for ascending, "DESC" for descending).
- Response:Status: 200 OK
- Body: List of `Movie` objects

### 2.Add New Movie
- Method: POST
- Endpoint: `/api/v1/movies/new-movie`
- Request Body: `Movie` object
- Response:Status: 200 OK if successful, 500 Internal Server Error if failed

### 3.Get Top Rated Movies
- Method: GET
- Endpoint: `/api/v1/movies/top-rated-movies`
- Request Parameters:`limit` (optional, default: 6.0): Specifies the minimum rating for movies to retrieve.
- `sortType` (optional, default: "DESC"): Specifies the sorting order of movies based on rating ("ASC" for ascending, "DESC" for descending).
- Response:Status: 200 OK
- Body: List of `Movie` objects

### 4.Get Genre Movies with Subtotals
- Method: GET
- Endpoint: `/api/v1/movies/genre-movies-with-subtotals`
- Response:Status: 200 OK
- Body: List of `Movie` objects

### 5.Update Runtime Minutes
- Method: POST
- Endpoint: `/api/v1/movies/update-runtime-minutes`
- Response:Status: 200 OK if successful, 500 Internal Server Error if failed







