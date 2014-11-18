/**
 * redpen: a text inspection tool
 * Copyright (C) 2014 Recruit Technologies Co., Ltd. and contributors
 * (see CONTRIBUTORS.md)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cc.redpen.validator.sentence;

import cc.redpen.model.Sentence;
import cc.redpen.validator.ValidationError;
import cc.redpen.validator.Validator;

import java.util.List;

/**
 * Validate input sentences except for first sentence of a paragraph start with
 * a space.
 */
final public class SpaceBeginningOfSentenceValidator extends Validator {

    @Override
    public void validate(List<ValidationError> errors, Sentence sentence) {
        String content = sentence.content;
        if (!sentence.isFirstSentence && content.length() > 0
                && !String.valueOf(content.charAt(0)).equals(" ")) {
            errors.add(createValidationError(sentence));
        }
    }
}
