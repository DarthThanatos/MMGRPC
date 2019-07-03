// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: helloworld.proto

package server;

/**
 * Protobuf type {@code helloworld.Verification}
 */
public  final class Verification extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:helloworld.Verification)
    VerificationOrBuilder {
  // Use Verification.newBuilder() to construct.
  private Verification(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Verification() {
    endGame_ = false;
    first_ = 0;
    second_ = 0;
    third_ = 0;
    fourth_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private Verification(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            server.Player.Builder subBuilder = null;
            if (player_ != null) {
              subBuilder = player_.toBuilder();
            }
            player_ = input.readMessage(server.Player.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(player_);
              player_ = subBuilder.buildPartial();
            }

            break;
          }
          case 16: {
            int rawValue = input.readEnum();

            first_ = rawValue;
            break;
          }
          case 24: {
            int rawValue = input.readEnum();

            second_ = rawValue;
            break;
          }
          case 32: {
            int rawValue = input.readEnum();

            third_ = rawValue;
            break;
          }
          case 40: {
            int rawValue = input.readEnum();

            fourth_ = rawValue;
            break;
          }
          case 48: {

            endGame_ = input.readBool();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return server.HelloWorldProto.internal_static_helloworld_Verification_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return server.HelloWorldProto.internal_static_helloworld_Verification_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            server.Verification.class, server.Verification.Builder.class);
  }

  public static final int ENDGAME_FIELD_NUMBER = 6;
  private boolean endGame_;
  /**
   * <code>optional bool endGame = 6;</code>
   */
  public boolean getEndGame() {
    return endGame_;
  }

  public static final int PLAYER_FIELD_NUMBER = 1;
  private server.Player player_;
  /**
   * <code>optional .helloworld.Player player = 1;</code>
   */
  public boolean hasPlayer() {
    return player_ != null;
  }
  /**
   * <code>optional .helloworld.Player player = 1;</code>
   */
  public server.Player getPlayer() {
    return player_ == null ? server.Player.getDefaultInstance() : player_;
  }
  /**
   * <code>optional .helloworld.Player player = 1;</code>
   */
  public server.PlayerOrBuilder getPlayerOrBuilder() {
    return getPlayer();
  }

  public static final int FIRST_FIELD_NUMBER = 2;
  private int first_;
  /**
   * <code>optional .helloworld.VerificationMarker first = 2;</code>
   */
  public int getFirstValue() {
    return first_;
  }
  /**
   * <code>optional .helloworld.VerificationMarker first = 2;</code>
   */
  public server.VerificationMarker getFirst() {
    server.VerificationMarker result = server.VerificationMarker.valueOf(first_);
    return result == null ? server.VerificationMarker.UNRECOGNIZED : result;
  }

  public static final int SECOND_FIELD_NUMBER = 3;
  private int second_;
  /**
   * <code>optional .helloworld.VerificationMarker second = 3;</code>
   */
  public int getSecondValue() {
    return second_;
  }
  /**
   * <code>optional .helloworld.VerificationMarker second = 3;</code>
   */
  public server.VerificationMarker getSecond() {
    server.VerificationMarker result = server.VerificationMarker.valueOf(second_);
    return result == null ? server.VerificationMarker.UNRECOGNIZED : result;
  }

  public static final int THIRD_FIELD_NUMBER = 4;
  private int third_;
  /**
   * <code>optional .helloworld.VerificationMarker third = 4;</code>
   */
  public int getThirdValue() {
    return third_;
  }
  /**
   * <code>optional .helloworld.VerificationMarker third = 4;</code>
   */
  public server.VerificationMarker getThird() {
    server.VerificationMarker result = server.VerificationMarker.valueOf(third_);
    return result == null ? server.VerificationMarker.UNRECOGNIZED : result;
  }

  public static final int FOURTH_FIELD_NUMBER = 5;
  private int fourth_;
  /**
   * <code>optional .helloworld.VerificationMarker fourth = 5;</code>
   */
  public int getFourthValue() {
    return fourth_;
  }
  /**
   * <code>optional .helloworld.VerificationMarker fourth = 5;</code>
   */
  public server.VerificationMarker getFourth() {
    server.VerificationMarker result = server.VerificationMarker.valueOf(fourth_);
    return result == null ? server.VerificationMarker.UNRECOGNIZED : result;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (player_ != null) {
      output.writeMessage(1, getPlayer());
    }
    if (first_ != server.VerificationMarker.GOOD_PLACE_AND_COLOR.getNumber()) {
      output.writeEnum(2, first_);
    }
    if (second_ != server.VerificationMarker.GOOD_PLACE_AND_COLOR.getNumber()) {
      output.writeEnum(3, second_);
    }
    if (third_ != server.VerificationMarker.GOOD_PLACE_AND_COLOR.getNumber()) {
      output.writeEnum(4, third_);
    }
    if (fourth_ != server.VerificationMarker.GOOD_PLACE_AND_COLOR.getNumber()) {
      output.writeEnum(5, fourth_);
    }
    if (endGame_ != false) {
      output.writeBool(6, endGame_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (player_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getPlayer());
    }
    if (first_ != server.VerificationMarker.GOOD_PLACE_AND_COLOR.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(2, first_);
    }
    if (second_ != server.VerificationMarker.GOOD_PLACE_AND_COLOR.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(3, second_);
    }
    if (third_ != server.VerificationMarker.GOOD_PLACE_AND_COLOR.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(4, third_);
    }
    if (fourth_ != server.VerificationMarker.GOOD_PLACE_AND_COLOR.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(5, fourth_);
    }
    if (endGame_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(6, endGame_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof server.Verification)) {
      return super.equals(obj);
    }
    server.Verification other = (server.Verification) obj;

    boolean result = true;
    result = result && (getEndGame()
        == other.getEndGame());
    result = result && (hasPlayer() == other.hasPlayer());
    if (hasPlayer()) {
      result = result && getPlayer()
          .equals(other.getPlayer());
    }
    result = result && first_ == other.first_;
    result = result && second_ == other.second_;
    result = result && third_ == other.third_;
    result = result && fourth_ == other.fourth_;
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    hash = (37 * hash) + ENDGAME_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getEndGame());
    if (hasPlayer()) {
      hash = (37 * hash) + PLAYER_FIELD_NUMBER;
      hash = (53 * hash) + getPlayer().hashCode();
    }
    hash = (37 * hash) + FIRST_FIELD_NUMBER;
    hash = (53 * hash) + first_;
    hash = (37 * hash) + SECOND_FIELD_NUMBER;
    hash = (53 * hash) + second_;
    hash = (37 * hash) + THIRD_FIELD_NUMBER;
    hash = (53 * hash) + third_;
    hash = (37 * hash) + FOURTH_FIELD_NUMBER;
    hash = (53 * hash) + fourth_;
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static server.Verification parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static server.Verification parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static server.Verification parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static server.Verification parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static server.Verification parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static server.Verification parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static server.Verification parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static server.Verification parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static server.Verification parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static server.Verification parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(server.Verification prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code helloworld.Verification}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:helloworld.Verification)
      server.VerificationOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return server.HelloWorldProto.internal_static_helloworld_Verification_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return server.HelloWorldProto.internal_static_helloworld_Verification_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              server.Verification.class, server.Verification.Builder.class);
    }

    // Construct using server.Verification.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      endGame_ = false;

      if (playerBuilder_ == null) {
        player_ = null;
      } else {
        player_ = null;
        playerBuilder_ = null;
      }
      first_ = 0;

      second_ = 0;

      third_ = 0;

      fourth_ = 0;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return server.HelloWorldProto.internal_static_helloworld_Verification_descriptor;
    }

    public server.Verification getDefaultInstanceForType() {
      return server.Verification.getDefaultInstance();
    }

    public server.Verification build() {
      server.Verification result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public server.Verification buildPartial() {
      server.Verification result = new server.Verification(this);
      result.endGame_ = endGame_;
      if (playerBuilder_ == null) {
        result.player_ = player_;
      } else {
        result.player_ = playerBuilder_.build();
      }
      result.first_ = first_;
      result.second_ = second_;
      result.third_ = third_;
      result.fourth_ = fourth_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof server.Verification) {
        return mergeFrom((server.Verification)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(server.Verification other) {
      if (other == server.Verification.getDefaultInstance()) return this;
      if (other.getEndGame() != false) {
        setEndGame(other.getEndGame());
      }
      if (other.hasPlayer()) {
        mergePlayer(other.getPlayer());
      }
      if (other.first_ != 0) {
        setFirstValue(other.getFirstValue());
      }
      if (other.second_ != 0) {
        setSecondValue(other.getSecondValue());
      }
      if (other.third_ != 0) {
        setThirdValue(other.getThirdValue());
      }
      if (other.fourth_ != 0) {
        setFourthValue(other.getFourthValue());
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      server.Verification parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (server.Verification) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private boolean endGame_ ;
    /**
     * <code>optional bool endGame = 6;</code>
     */
    public boolean getEndGame() {
      return endGame_;
    }
    /**
     * <code>optional bool endGame = 6;</code>
     */
    public Builder setEndGame(boolean value) {
      
      endGame_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional bool endGame = 6;</code>
     */
    public Builder clearEndGame() {
      
      endGame_ = false;
      onChanged();
      return this;
    }

    private server.Player player_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        server.Player, server.Player.Builder, server.PlayerOrBuilder> playerBuilder_;
    /**
     * <code>optional .helloworld.Player player = 1;</code>
     */
    public boolean hasPlayer() {
      return playerBuilder_ != null || player_ != null;
    }
    /**
     * <code>optional .helloworld.Player player = 1;</code>
     */
    public server.Player getPlayer() {
      if (playerBuilder_ == null) {
        return player_ == null ? server.Player.getDefaultInstance() : player_;
      } else {
        return playerBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .helloworld.Player player = 1;</code>
     */
    public Builder setPlayer(server.Player value) {
      if (playerBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        player_ = value;
        onChanged();
      } else {
        playerBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>optional .helloworld.Player player = 1;</code>
     */
    public Builder setPlayer(
        server.Player.Builder builderForValue) {
      if (playerBuilder_ == null) {
        player_ = builderForValue.build();
        onChanged();
      } else {
        playerBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>optional .helloworld.Player player = 1;</code>
     */
    public Builder mergePlayer(server.Player value) {
      if (playerBuilder_ == null) {
        if (player_ != null) {
          player_ =
            server.Player.newBuilder(player_).mergeFrom(value).buildPartial();
        } else {
          player_ = value;
        }
        onChanged();
      } else {
        playerBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>optional .helloworld.Player player = 1;</code>
     */
    public Builder clearPlayer() {
      if (playerBuilder_ == null) {
        player_ = null;
        onChanged();
      } else {
        player_ = null;
        playerBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>optional .helloworld.Player player = 1;</code>
     */
    public server.Player.Builder getPlayerBuilder() {
      
      onChanged();
      return getPlayerFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .helloworld.Player player = 1;</code>
     */
    public server.PlayerOrBuilder getPlayerOrBuilder() {
      if (playerBuilder_ != null) {
        return playerBuilder_.getMessageOrBuilder();
      } else {
        return player_ == null ?
            server.Player.getDefaultInstance() : player_;
      }
    }
    /**
     * <code>optional .helloworld.Player player = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        server.Player, server.Player.Builder, server.PlayerOrBuilder> 
        getPlayerFieldBuilder() {
      if (playerBuilder_ == null) {
        playerBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            server.Player, server.Player.Builder, server.PlayerOrBuilder>(
                getPlayer(),
                getParentForChildren(),
                isClean());
        player_ = null;
      }
      return playerBuilder_;
    }

    private int first_ = 0;
    /**
     * <code>optional .helloworld.VerificationMarker first = 2;</code>
     */
    public int getFirstValue() {
      return first_;
    }
    /**
     * <code>optional .helloworld.VerificationMarker first = 2;</code>
     */
    public Builder setFirstValue(int value) {
      first_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional .helloworld.VerificationMarker first = 2;</code>
     */
    public server.VerificationMarker getFirst() {
      server.VerificationMarker result = server.VerificationMarker.valueOf(first_);
      return result == null ? server.VerificationMarker.UNRECOGNIZED : result;
    }
    /**
     * <code>optional .helloworld.VerificationMarker first = 2;</code>
     */
    public Builder setFirst(server.VerificationMarker value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      first_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>optional .helloworld.VerificationMarker first = 2;</code>
     */
    public Builder clearFirst() {
      
      first_ = 0;
      onChanged();
      return this;
    }

    private int second_ = 0;
    /**
     * <code>optional .helloworld.VerificationMarker second = 3;</code>
     */
    public int getSecondValue() {
      return second_;
    }
    /**
     * <code>optional .helloworld.VerificationMarker second = 3;</code>
     */
    public Builder setSecondValue(int value) {
      second_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional .helloworld.VerificationMarker second = 3;</code>
     */
    public server.VerificationMarker getSecond() {
      server.VerificationMarker result = server.VerificationMarker.valueOf(second_);
      return result == null ? server.VerificationMarker.UNRECOGNIZED : result;
    }
    /**
     * <code>optional .helloworld.VerificationMarker second = 3;</code>
     */
    public Builder setSecond(server.VerificationMarker value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      second_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>optional .helloworld.VerificationMarker second = 3;</code>
     */
    public Builder clearSecond() {
      
      second_ = 0;
      onChanged();
      return this;
    }

    private int third_ = 0;
    /**
     * <code>optional .helloworld.VerificationMarker third = 4;</code>
     */
    public int getThirdValue() {
      return third_;
    }
    /**
     * <code>optional .helloworld.VerificationMarker third = 4;</code>
     */
    public Builder setThirdValue(int value) {
      third_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional .helloworld.VerificationMarker third = 4;</code>
     */
    public server.VerificationMarker getThird() {
      server.VerificationMarker result = server.VerificationMarker.valueOf(third_);
      return result == null ? server.VerificationMarker.UNRECOGNIZED : result;
    }
    /**
     * <code>optional .helloworld.VerificationMarker third = 4;</code>
     */
    public Builder setThird(server.VerificationMarker value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      third_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>optional .helloworld.VerificationMarker third = 4;</code>
     */
    public Builder clearThird() {
      
      third_ = 0;
      onChanged();
      return this;
    }

    private int fourth_ = 0;
    /**
     * <code>optional .helloworld.VerificationMarker fourth = 5;</code>
     */
    public int getFourthValue() {
      return fourth_;
    }
    /**
     * <code>optional .helloworld.VerificationMarker fourth = 5;</code>
     */
    public Builder setFourthValue(int value) {
      fourth_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional .helloworld.VerificationMarker fourth = 5;</code>
     */
    public server.VerificationMarker getFourth() {
      server.VerificationMarker result = server.VerificationMarker.valueOf(fourth_);
      return result == null ? server.VerificationMarker.UNRECOGNIZED : result;
    }
    /**
     * <code>optional .helloworld.VerificationMarker fourth = 5;</code>
     */
    public Builder setFourth(server.VerificationMarker value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      fourth_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>optional .helloworld.VerificationMarker fourth = 5;</code>
     */
    public Builder clearFourth() {
      
      fourth_ = 0;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:helloworld.Verification)
  }

  // @@protoc_insertion_point(class_scope:helloworld.Verification)
  private static final server.Verification DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new server.Verification();
  }

  public static server.Verification getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Verification>
      PARSER = new com.google.protobuf.AbstractParser<Verification>() {
    public Verification parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new Verification(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Verification> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Verification> getParserForType() {
    return PARSER;
  }

  public server.Verification getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

