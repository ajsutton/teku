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

package tech.pegasys.teku.spec.datastructures.execution;

import org.apache.tuweni.bytes.Bytes;
import org.apache.tuweni.bytes.Bytes32;
import tech.pegasys.teku.infrastructure.ssz.collections.SszByteList;
import tech.pegasys.teku.infrastructure.ssz.containers.ContainerSchema2;
import tech.pegasys.teku.infrastructure.ssz.primitive.SszBytes32;
import tech.pegasys.teku.infrastructure.ssz.schema.SszPrimitiveSchemas;
import tech.pegasys.teku.infrastructure.ssz.schema.collections.SszByteListSchema;
import tech.pegasys.teku.infrastructure.ssz.tree.TreeNode;

public class VerkleKeyValSchema extends ContainerSchema2<VerkleKeyVal, SszBytes32, SszByteList> {

  protected VerkleKeyValSchema() {
    super(
        "VerkleKeyVal",
        namedSchema("key", SszPrimitiveSchemas.BYTES32_SCHEMA),
        namedSchema("value", SszByteListSchema.create(32)));
  }

  @Override
  public VerkleKeyVal createFromBackingNode(final TreeNode node) {
    return new VerkleKeyVal(this, node);
  }

  public VerkleKeyVal create(final Bytes32 key, final Bytes value) {
    return new VerkleKeyVal(this, SszBytes32.of(key), getValueSchema().fromBytes(value));
  }

  @SuppressWarnings("unchecked")
  public SszByteListSchema<SszByteList> getValueSchema() {
    return (SszByteListSchema<SszByteList>) getFieldSchema1();
  }
}
