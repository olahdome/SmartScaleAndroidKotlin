package olah.dome.smartscale.model
import com.google.gson.annotations.SerializedName


data class Nutritions(
    val calories: Calories,
    val carbs: Carbs,
    val fat: Fat,
    val protein: Protein,
    val recipesUsed: Int
)

data class Fat(
    val confidenceRange95Percent: ConfidenceRange95Percent,
    val standardDeviation: Double,
    val unit: String,
    val value: Int
)

data class ConfidenceRange95Percent(
    val max: Double,
    val min: Double
)

data class Calories(
    val confidenceRange95Percent: ConfidenceRange95Percent,
    val standardDeviation: Double,
    val unit: String,
    val value: Int
)

data class Carbs(
    val confidenceRange95Percent: ConfidenceRange95Percent,
    val standardDeviation: Double,
    val unit: String,
    val value: Int
)

data class Protein(
    val confidenceRange95Percent: ConfidenceRange95Percent,
    val standardDeviation: Double,
    val unit: String,
    val value: Int
)