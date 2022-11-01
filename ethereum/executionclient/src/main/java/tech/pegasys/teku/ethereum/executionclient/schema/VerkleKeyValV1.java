/*
 * Copyright ConsenSys Software Inc., 2022
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package tech.pegasys.teku.ethereum.executionclient.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.tuweni.bytes.Bytes;
import org.apache.tuweni.bytes.Bytes32;
import tech.pegasys.teku.ethereum.executionclient.serialization.Bytes32Deserializer;
import tech.pegasys.teku.ethereum.executionclient.serialization.BytesDeserializer;
import tech.pegasys.teku.ethereum.executionclient.serialization.BytesSerializer;
import tech.pegasys.teku.spec.datastructures.execution.VerkleKeyVal;
import tech.pegasys.teku.spec.datastructures.execution.VerkleKeyValSchema;

public class VerkleKeyValV1 {

  @JsonSerialize(using = BytesSerializer.class)
  @JsonDeserialize(using = Bytes32Deserializer.class)
  private final Bytes32 key;

  @JsonSerialize(using = BytesSerializer.class)
  @JsonDeserialize(using = BytesDeserializer.class)
  private final Bytes value;

  public VerkleKeyValV1(
      @JsonProperty("key") final Bytes32 key, @JsonProperty("value") final Bytes value) {
    this.key = key;
    this.value = value;
  }

  public static VerkleKeyValV1 fromInternalVerkleKeyVal(final VerkleKeyVal verkleKeyVal) {
    return new VerkleKeyValV1(verkleKeyVal.getKey(), verkleKeyVal.getValue());
  }

  public VerkleKeyVal asInternalVerkleKeyVal(final VerkleKeyValSchema elementSchema) {
    return elementSchema.create(key, value);
  }
}
