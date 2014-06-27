Timber
======

Timber provides a lean wrapper around the default logging utility built into Android.

A `TAG` is auto-generated for you and your log statement is prefaced by `[method:line]`.  This was inspired by [DebugLog](https://github.com/MustafaFerhan/DebugLog).

Usage
-----

    Timber.v("Logging a verbose message...");

Will output something like this in logcat:

    V/com.indatus.android.timber.sample.MainActivity﹕ [onClick:30] Logginga verbose message...

Each of the verbosity levels from the default Log apply here:

- `Timber.v(...)`
- `Timber.d(...)`
- `Timber.i(...)`
- `Timber.w(...)`
- `Timber.e(...)`
- `Timber.wtf(...)`

### A Note on Performance

For improved performance, Timber was designed to use varargs rather than a single string.  Passing in multiple parameters will be more efficient if you separate them with a comma and let Timber handle the concatenation for you.

    Timber.d("Server response: ", response);

is preferable to:

    Timber.d("Server response: " + response);

The reasoning behind this has to do with the way an object's `toString()` method works.  If `response` in this case were a `StringBuilder`, which it often would be when collecting a server response, it would automatically call `response.toString()` so a single concatenated String can be passed in as the parameter.  So why is this a problem?  Let's suppose for a minute that `response` is fairly large in size.  Calling `toString()` (either explicitly or letting it be called implicitly) will create unnecessary overhead for a log statement that isn't even going to get executed in a release build.  Passing `response` to Timber as an argument (the first example) delays the `toString()` call until it's needed, thereby reducing wasted performance in your production app, but still providing you with important information when debugging.

License
-------

    Copyright 2014 Jonathon Staff

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
