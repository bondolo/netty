/*
 * Copyright 2022 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.netty5.channel;

import io.netty5.buffer.api.Buffer;
import io.netty5.buffer.api.BufferAllocator;

/**
 * Implementations of this interface can influence how {@link Buffer}s are allocated that are used when reading from
 * the transport.
 */
public interface ReadBufferAllocator {

    /**
     * Allocate a {@link Buffer} that is used for the next actual read to store the data in.
     *
     * <strong>This method is only expected to be called from the {@link Channel#executor()}.</strong>
     *
     * @param allocator             The {@link BufferAllocator} that might be used for the allocation.
     *                              While its fine to not use the {@link BufferAllocator} it is important that the
     *                              returned {@link Buffer} matches the {@link BufferAllocator#getAllocationType()}
     *                              of the allocator.
     * @param estimatedCapacity     the estimated capacity for the buffer. This is just a best guess and users might
     *                              decide to use their own capacity.
     * @return                      the {@link Buffer} that will be used or {@code null} if the read should not happen
     *                              until the next {@link ChannelOutboundInvoker#read(ReadBufferAllocator)} call is
     *                              done.
     */
    Buffer allocate(BufferAllocator allocator, int estimatedCapacity);
}
