/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.pubsublite.beam;

import com.google.auto.value.AutoOneOf;
import com.google.cloud.pubsublite.PublishMetadata;
import com.google.cloud.pubsublite.internal.CheckedApiException;
import com.google.cloud.pubsublite.internal.Publisher;

@AutoOneOf(PublisherOrError.Kind.class)
abstract class PublisherOrError {
  enum Kind {
    PUBLISHER,
    ERROR
  }

  abstract Kind getKind();

  abstract Publisher<PublishMetadata> publisher();

  abstract CheckedApiException error();

  static PublisherOrError ofPublisher(Publisher<PublishMetadata> p) {
    return AutoOneOf_PublisherOrError.publisher(p);
  }

  static PublisherOrError ofError(CheckedApiException e) {
    return AutoOneOf_PublisherOrError.error(e);
  }
}
