// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: helloworld.proto

package server;

public interface GamesByNameOrBuilder extends
    // @@protoc_insertion_point(interface_extends:helloworld.GamesByName)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional string name = 1;</code>
   */
  java.lang.String getName();
  /**
   * <code>optional string name = 1;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>repeated .helloworld.GameDescription games = 2;</code>
   */
  java.util.List<server.GameDescription> 
      getGamesList();
  /**
   * <code>repeated .helloworld.GameDescription games = 2;</code>
   */
  server.GameDescription getGames(int index);
  /**
   * <code>repeated .helloworld.GameDescription games = 2;</code>
   */
  int getGamesCount();
  /**
   * <code>repeated .helloworld.GameDescription games = 2;</code>
   */
  java.util.List<? extends server.GameDescriptionOrBuilder> 
      getGamesOrBuilderList();
  /**
   * <code>repeated .helloworld.GameDescription games = 2;</code>
   */
  server.GameDescriptionOrBuilder getGamesOrBuilder(
      int index);
}
