// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: helloworld.proto

package server;

public interface VerificationOrBuilder extends
    // @@protoc_insertion_point(interface_extends:helloworld.Verification)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional bool endGame = 6;</code>
   */
  boolean getEndGame();

  /**
   * <code>optional .helloworld.Player player = 1;</code>
   */
  boolean hasPlayer();
  /**
   * <code>optional .helloworld.Player player = 1;</code>
   */
  server.Player getPlayer();
  /**
   * <code>optional .helloworld.Player player = 1;</code>
   */
  server.PlayerOrBuilder getPlayerOrBuilder();

  /**
   * <code>optional .helloworld.VerificationMarker first = 2;</code>
   */
  int getFirstValue();
  /**
   * <code>optional .helloworld.VerificationMarker first = 2;</code>
   */
  server.VerificationMarker getFirst();

  /**
   * <code>optional .helloworld.VerificationMarker second = 3;</code>
   */
  int getSecondValue();
  /**
   * <code>optional .helloworld.VerificationMarker second = 3;</code>
   */
  server.VerificationMarker getSecond();

  /**
   * <code>optional .helloworld.VerificationMarker third = 4;</code>
   */
  int getThirdValue();
  /**
   * <code>optional .helloworld.VerificationMarker third = 4;</code>
   */
  server.VerificationMarker getThird();

  /**
   * <code>optional .helloworld.VerificationMarker fourth = 5;</code>
   */
  int getFourthValue();
  /**
   * <code>optional .helloworld.VerificationMarker fourth = 5;</code>
   */
  server.VerificationMarker getFourth();
}
