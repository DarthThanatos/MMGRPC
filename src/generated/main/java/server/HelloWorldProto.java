// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: helloworld.proto

package server;

public final class HelloWorldProto {
  private HelloWorldProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_helloworld_HelloRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_helloworld_HelloRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_helloworld_HelloReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_helloworld_HelloReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_helloworld_GamesByName_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_helloworld_GamesByName_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_helloworld_GameDescription_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_helloworld_GameDescription_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_helloworld_Player_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_helloworld_Player_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_helloworld_Combination_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_helloworld_Combination_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_helloworld_Verification_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_helloworld_Verification_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_helloworld_VerifyAck_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_helloworld_VerifyAck_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020helloworld.proto\022\nhelloworld\"\034\n\014HelloR" +
      "equest\022\014\n\004name\030\001 \001(\t\"\035\n\nHelloReply\022\017\n\007me" +
      "ssage\030\001 \001(\t\"G\n\013GamesByName\022\014\n\004name\030\001 \001(\t" +
      "\022*\n\005games\030\002 \003(\0132\033.helloworld.GameDescrip" +
      "tion\"\224\001\n\017GameDescription\022\020\n\010gameName\030\001 \001" +
      "(\t\022\024\n\014creationDate\030\003 \001(\t\022\016\n\006gameId\030\002 \001(\t" +
      "\022#\n\007guesser\030\004 \001(\0132\022.helloworld.Player\022$\n" +
      "\010verifier\030\005 \001(\0132\022.helloworld.Player\"^\n\006P" +
      "layer\022\020\n\010playerId\030\004 \001(\t\022\022\n\nplayerName\030\001 " +
      "\001(\t\022\016\n\006gameId\030\002 \001(\t\022\036\n\004role\030\003 \001(\0162\020.hell",
      "oworld.Role\"\273\001\n\013Combination\022\"\n\006player\030\001 " +
      "\001(\0132\022.helloworld.Player\022 \n\005first\030\002 \001(\0162\021" +
      ".helloworld.Color\022!\n\006second\030\003 \001(\0162\021.hell" +
      "oworld.Color\022 \n\005third\030\004 \001(\0162\021.helloworld" +
      ".Color\022!\n\006fourth\030\005 \001(\0162\021.helloworld.Colo" +
      "r\"\201\002\n\014Verification\022\017\n\007endGame\030\006 \001(\010\022\"\n\006p" +
      "layer\030\001 \001(\0132\022.helloworld.Player\022-\n\005first" +
      "\030\002 \001(\0162\036.helloworld.VerificationMarker\022." +
      "\n\006second\030\003 \001(\0162\036.helloworld.Verification" +
      "Marker\022-\n\005third\030\004 \001(\0162\036.helloworld.Verif",
      "icationMarker\022.\n\006fourth\030\005 \001(\0162\036.hellowor" +
      "ld.VerificationMarker\"\034\n\tVerifyAck\022\017\n\007me" +
      "ssage\030\001 \001(\t*.\n\004Role\022\013\n\007GUESSER\020\000\022\014\n\010VERI" +
      "FIER\020\001\022\013\n\007DEFAULT\020\002*I\n\005Color\022\007\n\003RED\020\000\022\010\n" +
      "\004BLUE\020\001\022\t\n\005GREEN\020\002\022\n\n\006YELLOW\020\003\022\n\n\006PURPLE" +
      "\020\004\022\n\n\006ORANGE\020\005*H\n\022VerificationMarker\022\030\n\024" +
      "GOOD_PLACE_AND_COLOR\020\000\022\016\n\nGOOD_COLOR\020\001\022\010" +
      "\n\004NONE\020\0022\220\005\n\007Greeter\022>\n\010SayHello\022\030.hello" +
      "world.HelloRequest\032\026.helloworld.HelloRep" +
      "ly\"\000\022C\n\rSayHelloAgain\022\030.helloworld.Hello",
      "Request\032\026.helloworld.HelloReply\"\000\022H\n\nCre" +
      "ateGame\022\033.helloworld.GameDescription\032\033.h" +
      "elloworld.GameDescription\"\000\022H\n\016GetGamesB" +
      "yName\022\033.helloworld.GameDescription\032\027.hel" +
      "loworld.GamesByName\"\000\0224\n\010JoinGame\022\022.hell" +
      "oworld.Player\032\022.helloworld.Player\"\000\022?\n\016W" +
      "aitForGuesser\022\027.helloworld.Combination\032\022" +
      ".helloworld.Player\"\000\022;\n\017WaitForVerifier\022" +
      "\022.helloworld.Player\032\022.helloworld.Player\"" +
      "\000\022<\n\005Guess\022\027.helloworld.Combination\032\030.he",
      "lloworld.Verification\"\000\022=\n\nGetGuesses\022\022." +
      "helloworld.Player\032\027.helloworld.Combinati" +
      "on\"\0000\001\022;\n\006Verify\022\030.helloworld.Verificati" +
      "on\032\025.helloworld.VerifyAck\"\000B!\n\006serverB\017H" +
      "elloWorldProtoP\001\242\002\003HLWb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_helloworld_HelloRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_helloworld_HelloRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_helloworld_HelloRequest_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_helloworld_HelloReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_helloworld_HelloReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_helloworld_HelloReply_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_helloworld_GamesByName_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_helloworld_GamesByName_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_helloworld_GamesByName_descriptor,
        new java.lang.String[] { "Name", "Games", });
    internal_static_helloworld_GameDescription_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_helloworld_GameDescription_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_helloworld_GameDescription_descriptor,
        new java.lang.String[] { "GameName", "CreationDate", "GameId", "Guesser", "Verifier", });
    internal_static_helloworld_Player_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_helloworld_Player_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_helloworld_Player_descriptor,
        new java.lang.String[] { "PlayerId", "PlayerName", "GameId", "Role", });
    internal_static_helloworld_Combination_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_helloworld_Combination_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_helloworld_Combination_descriptor,
        new java.lang.String[] { "Player", "First", "Second", "Third", "Fourth", });
    internal_static_helloworld_Verification_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_helloworld_Verification_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_helloworld_Verification_descriptor,
        new java.lang.String[] { "EndGame", "Player", "First", "Second", "Third", "Fourth", });
    internal_static_helloworld_VerifyAck_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_helloworld_VerifyAck_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_helloworld_VerifyAck_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}