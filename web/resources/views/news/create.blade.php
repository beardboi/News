<!doctype html>
<html lang="en">
@extends('layouts.app')
@section('content')
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
<div class="container-fluid">
    <div class="card col-lg-4 mx-auto">
        <!-- Card header -->
        <div class="card-header text-center font-weight-bold">
            The News Project - News form
        </div>

        <!-- TODO: display the errors -->

        <!-- Card body -->
        <div class="card-body">

            <!-- The Form, Action => NewsController@store TODO: Write validations !! -->
            {{ Form::open(['route' => 'news.store', 'method' => 'POST']) }}
            {{ Form::token() }}

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

@endsection
</html>


