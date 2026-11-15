# PrismaX

**A modular enhancement ecosystem for Geometry Dash, powered by Geode.**

PrismaX is developed as a dedicated project inside the `GD-Project` repository. It is not a separate repository.

## Targets

| Track | Geode | Status |
|---|---|---|
| Stable | 5.11.2 | Initial development target |
| Experimental | 6.0.0-alpha | Compatibility track; API/build validation pending |

Primary game target: Geometry Dash 2.2081  
Primary platform: Android  
Language: C++

## Project layout

- `versions/geode-5.11.2/` — stable implementation and build configuration.
- `versions/geode-6.0.0-alpha/` — isolated experimental implementation.
- `shared/` — code shared only when it is genuinely compatible with both SDK tracks.
- `branding/` — project identity and visual assets.
- `.github/workflows/` — PrismaX-specific automation, kept separate from repository workflows where possible.

Each Geode track owns its own `mod.json`, CMake configuration, source tree, and release artifacts. Shared code must not assume SDK APIs that differ between tracks.

## Ecosystem modules

- **PrismaX Core** — lifecycle, module registry, events, and configuration.
- **PrismaX UI** — the main in-game interface.
- **PrismaX Gameplay** — gameplay extensions and controls.
- **PrismaX Tools** — diagnostics and utilities.
- **PrismaX Extensions** — modular feature extensions.
- **PrismaX Cloud** — planned online services.
- **PrismaX Mega Hack** — an official ecosystem module with its own floating in-game interface.

The Mega Hack is part of PrismaX, not a separate product or repository.

## Development principles

1. Keep the two Geode SDK tracks isolated.
2. Validate Android ABI and SDK compatibility before declaring a build supported.
3. Keep gameplay modifications transparent and configurable.
4. Do not bundle Geometry Dash proprietary assets or game binaries.
5. Mark experimental features and builds clearly.

## Current milestone

**0.1.0 — Foundation:** establish the project layout, validate both SDK build environments, and implement the first minimal loadable PrismaX mod.
