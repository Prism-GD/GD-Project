# Version tracks

Each supported Geode SDK line has an isolated implementation directory.

- `geode-5.11.2/` — stable target for Geometry Dash 2.2081 on Android.
- `geode-6.0.0-alpha/` — experimental compatibility track.

Keep SDK-specific source, `mod.json`, CMake files, and build configuration inside the corresponding directory. Do not assume the alpha SDK is API- or binary-compatible with 5.11.2; verify against its actual SDK and toolchain before porting code.
