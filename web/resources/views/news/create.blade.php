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
    <div class="card col-lg-4 mx-auto">
        <!-- Card header -->
        <div class="card-header text-center font-weight-bold">
            The News Project - News form
        </div>
        <!-- Card body -->
        <div class="card-body">

            <!-- The Form, Action => NewsController@store TODO: Write validations !! -->
            <form name="add-news-form" id="news-form" method="post" action="{{url('store-form')}}">
            @csrf

            <!-- Fill the form -->
                <div class="form-group">
                    <label for="title" class="">
                        Title
                    </label>
                    <input type="text" id="title" name="title" class="form-control" required="required">
                </div>

                <div class="form-group">
                    <label for="author">
                        Author
                    </label>
                    <input type="text" id="author" name="author" class="form-control" required="required">
                </div>

                <div class="form-group">
                    <label for="source">
                        Source
                    </label>
                    <input type="text" id="source" name="source" class="form-control" required="required">
                </div>

                <div class="form-group">
                    <label for="url">
                        URL
                    </label>
                    <input type="text" id="url" name="url" class="form-control" required="required">
                </div>

                <div class="form-group">
                    <label for="url-image">
                        URL Image
                    </label>
                    <input type="text" id="url-image" name="url-image" class="form-control" required="required">
                </div>

                <div class="form-group">
                    <label for="description">
                        Description
                    </label>
                    <textarea id="description" name="description" class="form-control" required="required"></textarea>
                </div>

                <div class="form-group">
                    <label for="content">
                        Content
                    </label>
                    <textarea id="content" name="content" class="form-control" required="required"></textarea>
                </div>

                <button type="submit" class="btn btn-dark float-right">Submit</button>
            </form>

        </div>
    </div>
</body>

</html>
