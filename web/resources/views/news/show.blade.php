@extends('layouts.app')
@section('content')
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="card border-secondary">
                    <div class="card-header">
                        NOTICIA A LA HORA
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover" id="tab_trabajo">
                                <tbody>
                                <tr>
                                    <td style="vertical-align: middle">
                                        URL
                                    </td>
                                    <td>
                                        <input name="url" class="form-control" type="text" value="{{$new->url}}" readonly>
                                    </td>
                                </tr>
                                <tr id='news'>
                                    <td style="vertical-align: middle">
                                        Titulo
                                    </td>
                                    <td>
                                        <input name="title" class="form-control" type="text" value="{{ $new->title }}" readonly>
                                    </td>
                                </tr>

                                <tr>
                                    <td style="vertical-align: middle">
                                        Autor
                                    </td>
                                    <td>
                                        <input name="author" class="form-control" type="text" value="{{ $new->author }}" readonly>
                                    </td>
                                </tr>

                                <tr>
                                    <td style="vertical-align: middle">
                                        Fuente
                                    </td>
                                    <td>
                                        <input name="source" class="form-control" type="text" value="{{ $new->source }}" readonly>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="vertical-align: middle">
                                        Fecha
                                    </td>
                                    <td>
                                        <input name="date" class="form-control" type="text" value="{{$new->published_at}}" readonly>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="vertical-align: middle">
                                        Descripcion
                                    </td>
                                    <td>
                                        <input name="description" class="form-control" type="text" value="{{$new->description}}" readonly>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="vertical-align: middle">
                                        Content
                                    </td>
                                    <td>
                                        <input name="content" class="form-control" type="text" value="{{$new->content}}" readonly>
                                    </td>
                                </tr>
                                </tbody>

                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
@endsection
