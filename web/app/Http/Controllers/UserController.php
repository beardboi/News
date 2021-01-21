<?php
/*
 * Copyright 2020 Diego Bravo, diego.bravo@alumnos.ucn.cl
 *                             Daniel Suares, daniel.suares@alumnos.ucn.cl
 *                             Raul Ramos, raul.ramos@alumnos.ucn.cl
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom
 * the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

namespace App\Http\Controllers;

use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;

/**
 * Class UserController
 * @package App\Http\Controllers
 * @author Diego Bravo
 */
class UserController extends Controller
{
    function index(Request $request)
    {
        // Search the user
        $user = User::where('email', $request->email)->first();

        // If the password is not the correct one
        if (!$user || !Hash::check($request->password, $user->password)) {
            // Return
            return response([
                'message' => ['These credentials do not match our records.']
            ], 404);
        }

        // Create the token
        $token = $user->createToken('my-app-token')->plainTextToken;

        // Create the response
        $response = [
            'user' => $user,
            'token' => $token
        ];

        // Return response with status code 201
        return response($response, 201);
    }
}
