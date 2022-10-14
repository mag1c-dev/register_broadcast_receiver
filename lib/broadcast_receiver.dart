import 'package:broadcast_receiver/intent_filter.dart';
import 'package:flutter/services.dart';

class BroadcastReceiver {
  static const eventChannel = EventChannel('broadcast_receiver');

  static Stream<DataReceiver> registerBroadcast(IntentFilter intentFilter) {
    return eventChannel
        .receiveBroadcastStream(intentFilter.toMap())
        .map((event) => DataReceiver(event['action'], event['data']));
  }
}

class DataReceiver {
  final String action;
  final String data;

  DataReceiver(
    this.action,
    this.data,
  );
}
