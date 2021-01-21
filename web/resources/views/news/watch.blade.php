@extends('layouts.app')

@section('content')
    <div class="container">
        <h3 align="center">Daily News</h3>
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
                                <table class="table table-bordered table-hover" id="tab_news">
                                    <tr align="center">
                                        <!--title column-->
                                        <th>
                                            Title
                                        </th>
                                        <!--author column-->
                                        <th>
                                            Author
                                        </th>
                                        <!--source column-->
                                        <th>
                                            Source
                                        </th>
                                        <!--url column-->
                                        <th>
                                            URL
                                        </th>
                                        <!--action column-->
                                        <th>
                                            Action
                                        </th>
                                    </tr>
                                    <tbody>
                                    @foreach($news as $new)
                                        <tr id='atenciones'>
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
                                            <!--Url news-->
                                            <td align="center">
                                                {{$new->url}}
                                            </td>
                                            <td align="center">
                                                <a href="{{route('news.show', $new->id)}}">
                                                    <input type="submit" name="upload" class="btn btn-primary" value="Ver Noticia">
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
