# Flutter register_broadcast_receiver plugin

[![pub package](https://img.shields.io/pub/v/register_broadcast_receiver.svg)](https://pub.dev/packages/register_broadcast_receiver)

A Flutter plugin to register [Android broadcast receiver](https://developer.android.com/guide/components/broadcasts).

## Install

Add this to your package's `pubspec.yaml` file:


```yaml
dependencies:
  register_broadcast_receiver: ^0.0.1
```

## Usage

```dart
import 'dart:io';
import 'package:register_broadcast_receiver/register_broadcast_receiver.dart';

// Register broadcast.
BroadcastReceiver.registerBroadcast(
  IntentFilter(
    // Pass actions
    actions: [
      IntentFilter.ACTION_PACKAGE_ADDED,
      IntentFilter.ACTION_PACKAGE_REMOVED,
    ], 
    // Set priority, default = 0
    priority: 999,
    // Pass categories
    categories: [], 
    // Pass data schemes
    dataSchemes: [
      'package'
    ])).listen((event) {
      // Handle receiver here
    });
```

