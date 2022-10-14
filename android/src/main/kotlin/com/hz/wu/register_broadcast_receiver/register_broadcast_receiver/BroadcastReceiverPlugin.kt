package com.hz.wu.register_broadcast_receiver.register_broadcast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.annotation.NonNull

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.EventChannel

/** BroadcastReceiverPlugin */
class BroadcastReceiverPlugin: FlutterPlugin, EventChannel.StreamHandler {
  private lateinit var channel : EventChannel
  private lateinit var receiver : BroadcastReceiver
  private lateinit var context: Context

  override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    context = flutterPluginBinding.applicationContext
    channel = EventChannel(flutterPluginBinding.binaryMessenger, "register_broadcast_receiver")
    channel.setStreamHandler(this)
  }


  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
    channel.setStreamHandler(null)
  }

  override fun onListen(arguments: Any?, events: EventChannel.EventSink?) {
    receiver = object : BroadcastReceiver() {
      override fun onReceive(context: Context?, intent: Intent?) {
        events?.success(mapOf(
          "action" to intent?.action,
          "data" to intent?.dataString,
        ))
      }
    }
    val intentFilter = IntentFilter()
    intentFilter.priority = (arguments as Map<*, *>)["priority"] as Int
    (arguments["actions"] as List<*>).forEach {
      any ->      intentFilter.addAction(any as String)

    }
    (arguments["dataSchemes"] as List<*>).forEach {
      any ->      intentFilter.addDataScheme(any as String)

    }
    (arguments["categories"] as List<*>).forEach {
      any ->      intentFilter.addCategory(any as String)

    }

    context.registerReceiver(receiver, intentFilter)
  }

  override fun onCancel(arguments: Any?) {
    context.unregisterReceiver(receiver)
  }
}
