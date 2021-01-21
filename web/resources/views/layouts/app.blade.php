<!doctype html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- CSRF Token -->
    <meta name="csrf-token" content="{{ csrf_token() }}">

    <title>News</title>

    <!-- Scripts -->
    <script src="{{ asset('js/app.js') }}" defer></script>

    <!-- Fonts -->
    <link rel="dns-prefetch" href="//fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css?family=Nunito" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/jquery-ui-bootstrap/0.5pre/css/custom-theme/jquery-ui-1.10.0.custom.css" rel="stylesheet"/>
    <!-- Styles -->
    <link href="{{ asset('css/app.css') }}" rel="stylesheet">
    <style>
        body {
            background-color: #EFF0F1;
            padding-bottom: 55px;
        }

        footer {
            position: fixed;
            height: 55px;
            bottom: 0;
            left: 0;
            width: 100%;
            background-color: #23415B;
            text-align: center;
            color: rgba(245, 245, 245, .65);
        }

        .footer-text {
            font-size: 75%;
        }
    </style>
</head>
<body>
    <div id="app">
        <nav class="navbar navbar-expand-md navbar-dark"style="background-color: #23415B">
            <!-- Logo UCN -->
            <a class="navbar-brand">
                <img src="\img\Isologo-UCN-2018.png" height="40px" alt="Logo-UCN" loading="lazy">
            </a>
            <div class="container">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="{{ __('Toggle navigation') }}">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <!-- Left Side Of Navbar -->
                    <ul class="navbar-nav mr-auto">
                    </ul>
                    <!-- Right Side Of Navbar -->
                    <ul class="navbar-nav ml-auto">
                        <!-- Authentication Links -->
                        @guest
                            <!--Options that will be displayed if you are not registered-->
                            @if (Route::has('login'))
                                <li class="nav-item">
                                    <a class="nav-link" href="{{ route('login') }}">{{ __('Login') }}</a>
                                </li>
                            @endif
                            <!--Options that will be displayed if you are registered-->
                            @if (Route::has('register'))
                                <li class="nav-item">
                                    <a class="nav-link" href="{{ route('register') }}">{{ __('Register') }}</a>
                                </li>
                            @endif
                        @else
                            <!--Button to register user-->
                            <li class="nav-item">
                                <a class="nav-link" href="http://127.0.0.1:8000/news/create">Registrar Noticia<span class="sr-only">(current)</span></a>
                            </li>
                                <!--Button to manage news-->
                            <li class="nav-item">
                                <a class="nav-link" href="http://127.0.0.1:8000/news/table">Administrar noticias<span class="sr-only">(current)</span></a>
                            </li>
                                <!--Button to display news-->
                            <li class="nav-item">
                                <a class="nav-link" href="http://127.0.0.1:8000/news/watch"> Visualizar noticias<span class="sr-only">(current)</span></a>
                            </li>
                                <!--Button to json links-->
                                <li class="nav-item">
                                    <a class="nav-link" href="http://127.0.0.1:8000/news/json">Json<span class="sr-only">(current)</span></a>
                                </li>
                            <li class="nav-item dropdown">
                                <a id="navbarDropdown" class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" v-pre>
                                    {{ Auth::user()->name }}
                                </a>
                                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="{{ route('logout') }}"
                                       onclick="event.preventDefault();
                                                     document.getElementById('logout-form').submit();">
                                        {{ __('Logout') }}
                                    </a>

                                    <form id="logout-form" action="{{ route('logout') }}" method="POST" class="d-none">
                                        @csrf
                                    </form>
                                </div>
                            </li>
                        @endguest
                    </ul>
                </div>
            </div>
        </nav>

        <main class="py-4">
            @yield('content')
        </main>
    </div>
</body>
<footer>
    <!-- Copyright -->
    <div class="footer-copyright text-center py-3 footer-text">Desarrollo Soluciones Moviles - News:
        <br>
        <a style="color: #EFF0F1" href="https://www.ucn.cl/"> Universidad Católica del Norte </a>
        <a style="color: #EFF0F1" >Integrates: Raul Ramos, Diego Bravo, Daniel Suares </a>
    </div>
    <!-- Copyright -->
</footer>
</html>
