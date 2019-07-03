// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: helloworld.proto

package server;

/**
 * Protobuf enum {@code helloworld.VerificationMarker}
 */
public enum VerificationMarker
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>GOOD_PLACE_AND_COLOR = 0;</code>
   */
  GOOD_PLACE_AND_COLOR(0),
  /**
   * <code>GOOD_COLOR = 1;</code>
   */
  GOOD_COLOR(1),
  /**
   * <code>NONE = 2;</code>
   */
  NONE(2),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>GOOD_PLACE_AND_COLOR = 0;</code>
   */
  public static final int GOOD_PLACE_AND_COLOR_VALUE = 0;
  /**
   * <code>GOOD_COLOR = 1;</code>
   */
  public static final int GOOD_COLOR_VALUE = 1;
  /**
   * <code>NONE = 2;</code>
   */
  public static final int NONE_VALUE = 2;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static VerificationMarker valueOf(int value) {
    return forNumber(value);
  }

  public static VerificationMarker forNumber(int value) {
    switch (value) {
      case 0: return GOOD_PLACE_AND_COLOR;
      case 1: return GOOD_COLOR;
      case 2: return NONE;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<VerificationMarker>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      VerificationMarker> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<VerificationMarker>() {
          public VerificationMarker findValueByNumber(int number) {
            return VerificationMarker.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return server.HelloWorldProto.getDescriptor()
        .getEnumTypes().get(2);
  }

  private static final VerificationMarker[] VALUES = values();

  public static VerificationMarker valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private VerificationMarker(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:helloworld.VerificationMarker)
}

