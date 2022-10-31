package com.example.common.bean.musicComment

data class MusicCommentBean(
    val code: Int,
    val data: MusicCommentData
)

data class MusicCommentData(
    val comments: List<Comment>,
    val ownerComment : Comment,
    val commentsTitle: String,
    val currentCommentTitle: String,
    val cursor: String,
    val hasMore: Boolean,
    val sortType: Int,
    val style: String,
    val time: Long,
    val totalCount: Int
)

data class Comment(
    val beReplied: List<BeReplied>?,
    val commentId: Long,
    val commentLocationType: Int,
    val commentVideoVO: CommentVideoVO,
    val content: String,
    val decoration: Decoration,
    val ipLocation: IpLocation,
    val liked: Boolean,
    val likedCount: Int,
    val needDisplayTime: Boolean,
    val parentCommentId: Int,
    val pendantData: PendantData,
    val pickInfo: PickInfo,
    val repliedMark: Boolean,
    val replyCount: Int,
    val showFloorComment: ShowFloorComment,
    val status: Int,
    val threadId: String,
    val time: Long,
    val timeStr: String,
    val track: String,
    val user: User
)

data class BeReplied(
    val beRepliedCommentId: Int,
    val commentId: Int,
    val content: String?,
    val ipLocation: IpLocation,
    val status: Int,
    val user: User
)

data class CommentVideoVO(
    val allowCreation: Boolean,
    val forbidCreationText: String,
    val showCreationEntrance: Boolean,
    val videoCount: Int
)

data class Decoration(
    val repliedByAuthorCount: Int
)

data class IpLocation(
    val location: String
)

data class PendantData(
    val id: Int,
    val imageUrl: String
)

data class PickInfo(
    val status: String
)

data class ShowFloorComment(
    val replyCount: Int,
    val showReplyCount: Boolean
)

data class User(
    val anonym: Int,
    val authStatus: Int,
    val avatarDetail: AvatarDetail,
    val avatarUrl: String,
    val expertTags: List<String>,
    val followed: Boolean,
    val isHug: Boolean,
    val nickname: String,
    val userId: Long,
    val userType: Int,
    val vipRights: VipRights?,
    val vipType: Int
)

data class AvatarDetail(
    val identityIconUrl: String,
    val identityLevel: Int,
    val userType: Int
)

data class VipRights(
    val associator: Associator?,
    val musicPackage: MusicPackage,
    val redVipAnnualCount: Int,
    val redVipLevel: Int,
)

data class Associator(
    val iconUrl: String,
    val rights: Boolean,
    val vipCode: Int
)

data class MusicPackage(
    val iconUrl: String,
    val rights: Boolean,
    val vipCode: Int
)