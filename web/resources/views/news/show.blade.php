@extends('layouts.app')

@section('content')
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="card border-secondary">
                    <!--Title-->
                    <div class="card-header">
                        The News
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover" id="tab_show">
                                <tbody>
                                <!--URL parameter-->
                                <tr>
                                    <td style="vertical-align: middle">
                                        URL
                                    </td>
                                    <td>
                                        <input name="url" class="form-control" type="text" value="{{$new->url}}" readonly>
                                    </td>
                                </tr>
                                <!--Title parameter-->
                                <tr id='news'>
                                    <td style="vertical-align: middle">
                                        Title
                                    </td>
                                    <td>
                                        <input name="title" class="form-control" type="text" value="{{ $new->title }}" readonly>
                                    </td>
                                </tr>
                                <!--Author parameter-->
                                <tr>
                                    <td style="vertical-align: middle">
                                        Author
                                    </td>
                                    <td>
                                        <input name="author" class="form-control" type="text" value="{{ $new->author }}" readonly>
                                    </td>
                                </tr>
                                <!--Source parameter-->
                                <tr>
                                    <td style="vertical-align: middle">
                                        Source
                                    </td>
                                    <td>
                                        <input name="source" class="form-control" type="text" value="{{ $new->source }}" readonly>
                                    </td>
                                </tr>
                                <!--Date parameter-->
                                <tr>
                                    <td style="vertical-align: middle">
                                        Publish date
                                    </td>
                                    <td>
                                        <input name="date" class="form-control" type="text" value="{{$new->published_at}}" readonly>
                                    </td>
                                </tr>
                                <!--Description parameter-->
                                <tr>
                                    <td style="vertical-align: middle">
                                        Description
                                    </td>
                                    <td>
                                        <input name="description" class="form-control" type="text" value="{{$new->description}}" readonly>
                                    </td>
                                </tr>
                                <!--Content parameter-->
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
