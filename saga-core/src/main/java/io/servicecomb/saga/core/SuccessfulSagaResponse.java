/*
 * Copyright 2017 Huawei Technologies Co., Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.servicecomb.saga.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class SuccessfulSagaResponse implements SagaResponse {
  @JsonSerialize
  private final int statusCode;
  @JsonSerialize
  private final String body;

  public SuccessfulSagaResponse(@JsonProperty("statusCode") int statusCode, @JsonProperty("body") String content) {
    this.statusCode = statusCode;
    this.body = content;
  }

  @Override
  public boolean succeeded() {
    return true;
  }

  @Override
  public String body() {
    return String.format("{\n"
        + "  \"statusCode\": %d,\n"
        + "  \"content\": \"%s\"\n"
        + "}", statusCode, body);
  }
}