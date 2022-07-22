/*
 * Copyright 2021 The Netty Project
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

/**
 * {@link MaxMessagesRecvBufferAllocator} implementation which should be used for {@link ServerChannel}s.
 */
public final class ServerChannelRecvBufferAllocator extends DefaultMaxMessagesRecvBufferAllocator {
    public ServerChannelRecvBufferAllocator() {
        super(1, true);
    }

    @Override
    public Handle newHandle() {
        return new MaxMessageHandle() {
            @Override
            public int estimateBufferCapacity() {
                return 128;
            }
        };
    }
}
