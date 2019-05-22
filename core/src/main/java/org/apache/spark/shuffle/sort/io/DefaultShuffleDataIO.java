/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.shuffle.sort.io;

import org.apache.spark.SparkConf;
import org.apache.spark.api.shuffle.ShuffleDriverComponents;
import org.apache.spark.api.shuffle.ShuffleExecutorComponents;
import org.apache.spark.api.shuffle.ShuffleDataIO;
import org.apache.spark.shuffle.sort.lifecycle.DefaultShuffleDriverComponents;

public final class DefaultShuffleDataIO implements ShuffleDataIO {

  private final SparkConf sparkConf;

  public DefaultShuffleDataIO(SparkConf sparkConf) {
    this.sparkConf = sparkConf;
  }

  @Override
  public ShuffleExecutorComponents executor() {
    return new DefaultShuffleExecutorComponents(sparkConf);
  }

  @Override
  public ShuffleDriverComponents driver() {
    return new DefaultShuffleDriverComponents();
  }
}