<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>News Form</title>

    <!-- Styles -->
    <link href="{{ asset('css/app.css') }}" type="text/css" rel="stylesheet">

    <!-- Scripts -->
    <script src="{{ asset('js/app.js') }}" defer></script>

</head>

<body>

<div class="container-fluid">

    <div class="card col-lg-4 mx-auto">
        <!-- Card header -->
        <div class="card-header text-center font-weight-bold">
            The News Project - News form
        </div>
        <!-- Card body -->
        <div class="card-body">

            <!-- The Form, Action => NewsController@store TODO: Write validations !! -->
            {{ Form::open(['route' => 'news.store']) }}

            <div class="form-group">
                {{ Form::label('Title') }}
                {{ Form::text('title', null, ['class' => 'form-control', 'required']) }}
            </div>

            <div class="form-group">
                {{ Form::label('Author') }}
                {{ Form::text('author', null, ['class' => 'form-control', 'required']) }}
            </div>

            <div class="form-group">
                {{ Form::label('Source') }}
                {{ Form::text('source', null, ['class' => 'form-control', 'required']) }}
            </div>

            <div class="form-group">
                {{ Form::label('URL') }}
                {{ Form::text('url', null, ['class' => 'form-control', 'required']) }}
            </div>

            <div class="form-group">
                {{ Form::label('URL Image') }}
                {{ Form::text('url_image', null, ['class' => 'form-control', 'required']) }}
            </div>

            <div class="form-group">
                {{ Form::label('Description') }}
                {{ Form::textarea('description', null, ['class' => 'form-control', 'required', 'rows' => '3', 'style' => 'resize: none']) }}
            </div>

            <div class="form-group">
                {{ Form::label('Content') }}
                {{ Form::textarea('content', null, ['class' => 'form-control', 'required', 'rows' => '5', 'style' => 'resize: none']) }}
            </div>

            <div class="form-group">
                <!-- Button to submit the form -->
                {{ Form::submit('Submit', ['class' => 'btn btn-primary float-right']) }}
            </div>

            {{ Form::close() }}

        </div>
    </div>
</div>

</body>

</html>
