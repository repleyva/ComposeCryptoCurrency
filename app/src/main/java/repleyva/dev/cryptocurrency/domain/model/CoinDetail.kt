package repleyva.dev.cryptocurrency.domain.model

import repleyva.dev.cryptocurrency.data.remote.dto.*

data class CoinDetail(
    val id: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val is_active: Boolean,
    val tags: List<Tag>,
    val team: List<TeamMember>,
)
