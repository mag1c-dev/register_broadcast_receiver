# Flutter broadcast_receiver plugin



A Flutter plugin to register [Android broadcast receiver](https://developer.android.com/guide/components/broadcasts).

## Install

Add this to your package's `pubspec.yaml` file:


```yaml
dependencies:
  broadcast_receiver:
    git:
      url: https://github.com/ag1le0/broadcast_receiver
```

## Usage

```dart
import 'dart:io';
import 'package:broadcast_receiver/broadcast_receiver.dart';

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

