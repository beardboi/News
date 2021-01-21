# The News Project
Assignament for Desarrollo de Soluciones Móviles. App developed in Android Studio and API Rest developed in PHPStorm, using the framework of Laravel.

## Installation

First you have to clone the project

```bash
git clone https://github.com/beardboi/The-News-Project
```
Then, you need to config the file .env, setting the database.

```bash
...
DB_CONNECTION=sqlite
DB_HOST=127.0.0.1
DB_PORT=3306
DB_DATABASE=".../news/web/database/database.sqlite"
DB_USERNAME=root
DB_PASSWORD=
...
```
After that, you have to run the migrations inside the laravel project directory using the command:
```bash
php artisan migrate
```
Follow after that you probably would want to test the API, so it would be good run the seed of the database. This can be done by writing the command:

```bash
php artisan db:seed
```
Finally, you can access to the endpoint in the url:

```bash
https://localhost:8000/api/news
```

## Status

Currently in development.

## Contributing
- Raul Ramos
- Diego Bravo
- Daniel Suares

## License
[MIT](https://choosealicense.com/licenses/mit/)

