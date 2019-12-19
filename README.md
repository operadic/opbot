# opbot -- an operadic bot meets repl

NOTE: This is very much a work-in-progress.

## Goal
The initial goals are:
1. Provide a working copy/wrapper of fiatjaf's excellent `@lntxbot` Telegram bot: https://git.alhur.es/fiatjaf/lntxbot
2. Abstract out the telegram-specific items/api.
3. Provide implementations of the bot via other methods such as over email (e.g. in an email-chain rather than a telegram chat room)
4. More people can then enjoy the great features of the bot (such as the `sats4ads` feature)

## Current Considerations?
1. `@lntxbot` is written in Go, but our wrapper/implemention may not need to be (or should it be?)
2. How "operadic" (in the mathematical sense) can we make this without slowing down initial development and release process too much? Eventually of course the goal is to have it be fully operadic, but we need to start somewhere!

