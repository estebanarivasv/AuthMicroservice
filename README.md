# AuthMicroservice

### Recommended requirements
For running without Docker:
- AdoptOpenJDK (15.0.2)
- Apache Maven (3.8.1)

For running with Docker:
- Docker (version 20.10.7)
- docker-compose (version 1.29.2)

### How to get the application up and running?
First, define environment variables creating an .env file in `/docker` (see .env-example as an example).

Then, append to the desired build the `.jar` extension in order to use it with Docker

Finally, run docker compose command at `/AuthMicroservice/docker` level:

        docker-compose up

Note: Before running docker compose, please verify that you had not created an image with the same name. If so, you should rename image creation from docker compose