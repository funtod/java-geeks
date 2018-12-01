package com.hillel.elementary.javageeks.exception;

public class HigherException extends Exception {
}
class MidleException extends HigherException{

}
class LowerException extends MidleException{

}