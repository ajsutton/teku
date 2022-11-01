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
import tech.pegasys.teku.infrastructure.ssz.containers.Container2;
import tech.pegasys.teku.infrastructure.ssz.primitive.SszBytes32;
import tech.pegasys.teku.infrastructure.ssz.tree.TreeNode;

public class VerkleKeyVal extends Container2<VerkleKeyVal, SszBytes32, SszByteList> {

  protected VerkleKeyVal(final VerkleKeyValSchema schema, final TreeNode backingNode) {
    super(schema, backingNode);
  }

  protected VerkleKeyVal(
      final VerkleKeyValSchema schema, final SszBytes32 key, final SszByteList value) {
    super(schema, key, value);
  }

  public Bytes32 getKey() {
    return getField0().get();
  }

  public Bytes getValue() {
    return getField1().getBytes();
  }
}
