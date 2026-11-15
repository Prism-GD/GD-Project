# Shared code

Place SDK-independent utilities and data models here only when they can be compiled and tested in both Geode tracks.

Do not put Geode hooks, SDK headers, platform-specific UI code, or version-specific build configuration here. If an API differs between SDK versions, keep its adapter inside the corresponding `versions/` directory.
