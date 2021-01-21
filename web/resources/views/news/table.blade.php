@extends('layouts.app')

@section('content')
    <div class="container">
        <h3 align="center">The News</h3>
        <br />
        <div class="row">
            <div class="col-md-12">
                @if(count($news) != 0)
                    <div class="card border-secondary">
                        <div class="card-header">
                            News
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover" id="tab_Delete">
                                    <tr align="center">
                                        <!--title column-->
                                        <th>
                                            Title
                                        </th>
                                        <!--author column-->
                                        <th>
                                            Author
                                        </th>
                                        <!--Source column-->
                                        <th>
                                            Source
                                        </th>
                                        <!--URL column-->
                                        <th>
                                            URL
                                        </th>
                                        <!--URL image column-->
                                        <th>
                                            URL image
                                        </th>
                                        <!--Description column-->
                                        <th>
                                            Description
                                        </th>
                                        <!--Content column-->
                                        <th>
                                            Content
                                        </th>
                                        <!--Date column-->
                                        <th>
                                            Date
                                        </th>
                                        <!--Action button-->
                                        <th>
                                            Action
                                        </th>
                                    </tr>
                                    <tbody>
                                    @foreach($news as $new)
                                        <tr id='Eliminar'>
                                            <!--Title news-->
                                            <td align="center">
                                                {{$new->title}}
                                            </td>
                                            <!--Author news-->
                                            <td align="center">
                                                {{$new->author}}
                                            </td>
                                            <!--Source news-->
                                            <td align="center">
                                                {{$new->source}}
                                            </td>
                                            <!--URL news-->
                                            <td align="center">
                                                {{$new->url}}
                                            </td>
                                            <!--URL image news-->
                                            <td align="center">
                                                {{$new->url_image}}
                                            </td>
                                            <!--Description news-->
                                            <td align="center">
                                                {{$new->description}}
                                            </td>
                                            <!--content news-->
                                            <td align="center">
                                                {{$new->content}}
                                            </td>
                                            <!--Date news-->
                                            <td align="center">
                                                {{$new->published_at}}
                                            </td>
                                            <td align="center">
                                                <!--Addressing and confirmation tab-->
                                                <a href="{{route('news.destroy', $new->id)}}" onclick="return confirm('Are you sure to delete this News?')">
                                                    <input type="submit" name="upload" class="delete btn btn-danger btn-sm" value="Eliminar" >
                                                </a>
                                            </td>
                                        </tr>
                                    @endforeach
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <br>
                @else
                    <div class="card border-secondary">
                        <div class="card-header">
                            News
                        </div>
                        <div class="card-body">
                            <h6 align="center"> There is no recorded news. </h6>
                        </div>
                    </div>
                @endif
            </div>
        </div>
    </div>
@endsection
