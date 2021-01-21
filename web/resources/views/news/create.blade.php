@extends('layouts.app')

@section('content')
    <div class="container-fluid">
        <div class="card col-lg-4 mx-auto">
            <!-- Card header -->
            <div class="card-header text-center font-weight-bold">
                The News Project - News form
            </div>

        <!-- Error display -->
            @if ($errors->any())
                <div class="alert alert-danger">
                    <ul>
                        @foreach ($errors->all() as $error)
                            <li>{{ $error }}</li>
                        @endforeach
                    </ul>
                </div>
            @endif
        <!-- Success display -->
            @if(session('info'))
                <div class="container">
                    <div class="row">
                        <div class="col-md-8 mx-auto">
                            <div class="alert alert-success">
                                {{ session('info') }}
                            </div>
                        </div>
                    </div>
                </div>
            @endif

        <!-- Card body -->
            <div class="card-body">

                <!-- The Form, Action => NewsController@store TODO: Write validations !! -->
                {{ Form::open(['route' => 'news.store', 'method' => 'POST']) }}
                {{ Form::token() }}

                <div class="form-group">
                    {{ Form::label('Title') }}
                    {{ Form::text('title', null, ['class' => 'form-control', 'required', 'placeholder' => 'Enter the title of the News']) }}
                </div>

                <div class="form-group">
                    {{ Form::label('Author') }}
                    {{ Form::text('author', null, ['class' => 'form-control', 'required', 'placeholder' => 'Enter the author of the News']) }}
                </div>

                <div class="form-group">
                    {{ Form::label('Source') }}
                    {{ Form::text('source', null, ['class' => 'form-control', 'required', 'placeholder' => 'Enter the source of the News']) }}
                </div>

                <div class="form-group">
                    {{ Form::label('URL') }}
                    {{ Form::text('url', null, ['class' => 'form-control', 'required', 'placeholder' => 'Enter the url of the News']) }}
                </div>

                <div class="form-group">
                    {{ Form::label('URL Image') }}
                    {{ Form::text('url_image', null, ['class' => 'form-control', 'required', 'placeholder' => 'Enter the url image of the News']) }}
                </div>

                <div class="form-group">
                    {{ Form::label('Description') }}
                    {{ Form::textarea('description', null, ['class' => 'form-control', 'required', 'rows' => '3', 'style' => 'resize: none', 'placeholder' => 'Enter the description of the News']) }}
                </div>

                <div class="form-group">
                    {{ Form::label('Content') }}
                    {{ Form::textarea('content', null, ['class' => 'form-control', 'required', 'rows' => '5', 'style' => 'resize: none', 'placeholder' => 'Enter the content of the News']) }}
                </div>

                <div class="form-group">
                    <!-- Button to submit the form -->
                    {{ Form::submit('Publish', ['class' => 'btn btn-primary float-right']) }}
                </div>

                {{ Form::close() }}
            </div>
        </div>
    </div>
@endsection



