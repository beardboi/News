@extends('layouts.app')

@section('content')
    <div class="container">
        <h3 align="center"> Links </h3>
        <br />
        <div class="row">
            <div class="col-md-12">
                    <div class="card border-secondary">
                        <div class="card-header">
                            Json Links
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover" id="tab_news">
                                    <tr align="center">
                                        <!--link column-->
                                        <th>
                                            All Json
                                        </th>
                                        <!--Size column-->
                                        <th>
                                            Page Size
                                        </th>
                                        <!--Page column-->
                                        <th>
                                            Page
                                        </th>
                                        <!--q column-->
                                        <th>
                                            Search
                                        </th>
                                    </tr>
                                    <tbody>
                                        <tr id='jsons'>
                                            <!--link all json-->
                                            <td align="center"> http://127.0.0.1:8000/api/news </td>
                                            <!--links size-->
                                            <td align="center"> http://127.0.0.1:8000/api/news/?pageSize= </td>
                                            <!--links page-->
                                            <td align="center"> http://127.0.0.1:8000/api/news/?page= </td>
                                            <!--Source news-->
                                            <td align="center"> http://127.0.0.1:8000/api/news/q/ </td>
                                        </tr>
                                    </tbody>
                                    <tbody>
                                    <tr id='secondTable'>
                                        <!--link all json-->
                                        <td align="center"> Enter this link if you want to see all the api </td>
                                        <!--links size-->
                                        <td align="center"> Enter this link if you want to control the amount of api per page, enter the amount after the equal </td>
                                        <!--links page-->
                                        <td align="center"> Enter this link if you want to see the page, enter the page you want to enter after the equal </td>
                                        <!--Link search-->
                                        <td align="center"> Enter this if you want to filter by title, enter the title to search after the slash </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <br>
            </div>
        </div>
    </div>
@endsection
