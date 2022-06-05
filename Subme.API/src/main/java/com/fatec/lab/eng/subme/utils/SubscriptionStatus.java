package com.fatec.lab.eng.subme.utils;

public enum SubscriptionStatus {
 ACTIVE(1), SUSPENDED(2), CANCELED(3);
 public int value;

 SubscriptionStatus(int value) {
  this.value = value;
 }

}
