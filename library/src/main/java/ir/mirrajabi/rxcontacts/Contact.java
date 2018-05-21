/*
 * Copyright (C) 2016 Ulrich Raab.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ir.mirrajabi.rxcontacts;


import android.net.Uri;
import android.support.annotation.NonNull;

import java.util.HashSet;
import java.util.Set;


/**
 * Contact entity.
 *
 * @author Ulrich Raab
 * @author Mohammad Mirrajabi
 */

public class Contact implements Comparable<Contact> {
    private final long mId;
    private int mInVisibleGroup;
    private String mDisplayName;
    private boolean mStarred;
    private Uri mPhoto;
    private Uri mThumbnail;
    private Set<String> mEmails = new HashSet<>();
    private Set<String> mPhoneNumbers = new HashSet<>();

    Contact(long id) {
        this.mId = id;
    }

    public long getId() {
        return mId;
    }

    public int getInVisibleGroup() {
        return mInVisibleGroup;
    }

    public void setInVisibleGroup(int inVisibleGroup) {
        mInVisibleGroup = inVisibleGroup;
    }

    public String getDisplayName() {
        return mDisplayName;
    }

    public void setDisplayName(String displayName) {
        mDisplayName = displayName;
    }

    public boolean isStarred() {
        return mStarred;
    }

    public void setStarred(boolean starred) {
        mStarred = starred;
    }

    public Uri getPhoto() {
        return mPhoto;
    }

    public void setPhoto(Uri photo) {
        mPhoto = photo;
    }

    public Uri getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(Uri thumbnail) {
        mThumbnail = thumbnail;
    }

    public Set<String> getEmails() {
        return mEmails;
    }

    public void setEmails(Set<String> emails) {
        mEmails = emails;
    }

    public Set<String> getPhoneNumbers() {
        return mPhoneNumbers;
    }

    public void setPhoneNumbers(Set<String> phoneNumbers) {
        mPhoneNumbers = phoneNumbers;
    }


    @Override
    public int compareTo(@NonNull Contact other) {
        if (mDisplayName != null && other.mDisplayName != null) {
            return mDisplayName.compareTo(other.mDisplayName);
        }

        return -1;
    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Contact contact = (Contact) o;
        return mId == contact.mId;
    }
}
